package cn.com.zhirun.ssm.controller;

import cn.com.zhirun.ssm.model.MemberModel;
import cn.com.zhirun.ssm.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MemberController {
    @Autowired
    MemberService memberService;

    @RequestMapping("/selectByPrimaryKey")
    public ModelAndView selectByPrimaryKey(Integer id) {
        MemberModel memberModel = memberService.selectByPrimaryKey(id);

        ModelAndView mav = new ModelAndView();
        mav.addObject("member", memberModel);
        mav.setViewName("result");
        return mav;
    }

    @RequestMapping("/jumpTo")
    public String jumpTo() {
        return "result";
    }

    @ResponseBody
    @RequestMapping("/selectByAjax")
    public MemberModel selectByAjax(Integer id) {
        MemberModel memberModel = memberService.selectByPrimaryKey(id);
        return memberModel;
    }

    @ResponseBody
    @RequestMapping("/selectByAjaxAdvanced")
    public ModelMap selectByAjaxAdvanced(Integer id) {
        ModelMap modelMap = new ModelMap();
        MemberModel memberModel = memberService.selectByPrimaryKey(id);
        modelMap.put("result", memberModel);

        return modelMap;
    }

    @RequestMapping("/deleteById")
    public ModelAndView deleteByPrimaryKey(Integer deleteid) {
        ModelAndView mav = new ModelAndView();
        int n = memberService.deleteByPrimaryKey(deleteid);
        mav.addObject("r", n);
        mav.setViewName("result");
        return mav;
    }

    @RequestMapping("/insertMember")
    public ModelAndView insertMember(MemberModel memberModel) {
        ModelAndView mav = new ModelAndView();
        int n = memberService.insertMember(memberModel);
        mav.addObject("r", n);
        mav.setViewName("result");
        return mav;
    }

    @RequestMapping("/selectMembers")
    public ModelAndView selectMembers(MemberModel memberModel) {
        ModelAndView mav = new ModelAndView();
        List<MemberModel> memList = memberService.selectMembers(memberModel);
        mav.addObject("memList", memList);
        mav.setViewName("result");
        return mav;
    }

    @RequestMapping("/selectMembersByIds")
    public ModelAndView selectMembersByIds(String[] ids) {
        ModelAndView mav = new ModelAndView();
        List<MemberModel> memList = memberService.selectMembersByIds(ids);
        mav.addObject("memList", memList);
        mav.setViewName("result");
        return mav;
    }

    /*@ResponseBody
    @RequestMapping("/selectByIdsAjax")
    public ModelMap selectByIdsAjax(@RequestParam("idz[]") String[] idz) {
        List ids = Array.asList
        ModelMap modelMap = new ModelMap();
        modelMap = memberService.selectMembersByIds(idz);
    }*/
}
