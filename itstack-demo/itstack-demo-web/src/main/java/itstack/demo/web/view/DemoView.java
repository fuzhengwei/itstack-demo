package itstack.demo.web.view;

import itstack.demo.common.utils.GsonUtils;
import itstack.demo.domain.req.QueryAgentReq;
import itstack.demo.domain.res.AgentRes;
import itstack.demo.service.AgentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 * User: fuzhengwei1
 * Date: 16-3-1
 * Time: 下午2:43
 * To change this template use File | Settings | File Templates.
 */
@Controller("demoView")
@RequestMapping("/demoView/")
public class DemoView {

    private Logger logger = LoggerFactory.getLogger(DemoView.class);

    @Autowired
    private AgentService agentService;

    @RequestMapping(value = "doQueryDemo")
    public ModelAndView doQueryDemo() {
        logger.info("查询。req：");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/index");
        System.out.println("ok");
        logger.info("查询。res：");
        return mv;
    }

    /**
     * url http://localhost/demoView/doQueryAgent.do
     * @return
     */
    @RequestMapping(value = "doQueryAgent")
    public ModelAndView doQueryAgent(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/index");
        AgentRes agentRes = agentService.queryAgent(new QueryAgentReq());
        mv.addObject("agentRes",agentRes);
        logger.info("查询代理人信息。res："+ GsonUtils.toJson(agentRes));
        return mv;
    }

    @RequestMapping(value = "doQueryAgentJson")
    @ResponseBody
    public AgentRes doQueryAgentJson(){
        AgentRes agentRes = agentService.queryAgent(new QueryAgentReq());
        logger.info("查询代理人信息。res："+ GsonUtils.toJson(agentRes));
        return agentRes;
    }

}
