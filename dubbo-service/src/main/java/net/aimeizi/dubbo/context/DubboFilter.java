package net.aimeizi.dubbo.context;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;

@Activate(group = {Constants.PROVIDER, Constants.CONSUMER})
public class DubboFilter implements Filter {

    public static final String USER_INFO = "USER_INFO";

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        Result result;
        String role = invoker.getUrl().getParameter(Constants.SIDE_KEY);
        SessionInfo sessionInfo = LocalSessionHelper.getUserSessionInfo();
        if (sessionInfo == null){
            sessionInfo = new SessionInfo();
            sessionInfo.setUserName("Wang");
        }

        if (Constants.CONSUMER.equals(role)) {// consumer
            RpcContext.getContext().setAttachment(USER_INFO, sessionInfo.getUserName()); //TODO add json
        } else if (Constants.PROVIDER.equals(role)) {// provider
            ThreadLocalHolder.set(USER_INFO, invocation.getAttachment(USER_INFO));
        }
        try {
            result = invoker.invoke(invocation);
        } catch (Exception e) {
            throw new RpcException(e);
        }
        return result;
    }

}
