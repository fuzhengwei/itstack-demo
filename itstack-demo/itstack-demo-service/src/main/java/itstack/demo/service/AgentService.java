package itstack.demo.service;

import itstack.demo.domain.req.QueryAgentReq;
import itstack.demo.domain.res.AgentRes;

/**
 * Created with IntelliJ IDEA.
 * User: fuzhengwei1
 * Date: 16-3-1
 * Time: 下午5:44
 * To change this template use File | Settings | File Templates.
 */
public interface AgentService {

    public AgentRes queryAgent(QueryAgentReq queryAgentReq);

}
