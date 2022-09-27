package in.co.health.care.mgt.sys.util;

import org.springframework.ui.Model;

import in.co.health.care.mgt.sys.ctl.BaseCtl;

public class ControllerUtility {
	
	public static void setSuccessMessage(String msg,Model model) {
		model.addAttribute(BaseCtl.SUCCESS, msg);
	}
	
	public static void setErrorMessage(String msg,Model model) {
		model.addAttribute(BaseCtl.ERROR, msg);
	}

}
