package itstack.demo.service.impl;

import itstack.demo.common.constants.Constants;
import itstack.demo.common.domain.Result;
import itstack.demo.common.utils.GsonUtils;
import itstack.demo.dao.AgentDao;
import itstack.demo.domain.po.Agent;
import itstack.demo.domain.req.QueryAgentReq;
import itstack.demo.domain.res.AgentRes;
import itstack.demo.service.AgentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: fuzhengwei1
 * Date: 16-3-1
 * Time: 下午5:45
 * To change this template use File | Settings | File Templates.
 */
@Service("agentService")
public class AgentServiceImpl implements AgentService {

    private Logger logger = LoggerFactory.getLogger(AgentServiceImpl.class);

    @Autowired
    private AgentDao agentDao;

    @Override
    public AgentRes queryAgent(QueryAgentReq queryAgentReq) {
        String requestReq = GsonUtils.toJson(queryAgentReq);
        AgentRes agentRes = new AgentRes();
        try {
            logger.info("查询代理人信息。req：{}", requestReq);
            List<Agent> agents = agentDao.queryAgent();
            logger.info("查询代理人信息。res：{}",GsonUtils.toJson(agents));
            agentRes.setResult(Result.buildSuccessResult());
            agentRes.setAgents(agents);
        } catch (Exception e) {
             logger.error("查询代理人信息失败。req："+requestReq,e);
            agentRes.setResult(Result.buildFailedResult(Constants.ResponseCode.UNKNOWN_ERROR,Constants.ResponseInfo.UNKNOWN_ERROR));
        }
        return agentRes;
    }
}
