package itstack.demo.domain.res;

import itstack.demo.common.domain.Result;
import itstack.demo.domain.po.Agent;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: fuzhengwei1
 * Date: 16-3-1
 * Time: 下午5:40
 * To change this template use File | Settings | File Templates.
 */
public class AgentRes {

    private Result result;
    private List<Agent> agents;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public void setAgents(List<Agent> agents) {
        this.agents = agents;
    }
}
