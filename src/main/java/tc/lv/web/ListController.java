package tc.lv.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tc.lv.domain.IpAddress;
import tc.lv.exceptions.IpAddressServiceException;
import tc.lv.exceptions.IpStatusListServiceException;
import tc.lv.service.IpAddressService;
import tc.lv.service.IpStatusListService;
import tc.lv.utils.ExceptionUtil;
import tc.lv.utils.IpValidator;

@Controller
public class ListController {

	@Autowired
	private IpStatusListService ipStatusListService;

	@Autowired
	private IpAddressService ipAddressService;

	// Delete IP-address from WhiteList
	@RequestMapping(value = "admin_deleteIpFromList", method = RequestMethod.GET)
	public String deleteIpFromWhiteList() {
		return "admin_deleteIpFromList";
	}

	// Delete IP-address from WhiteList
	@RequestMapping(value = "admin_deleteIpFromList", method = RequestMethod.POST)
	public String deleteIpFromWhiteList(
			@ModelAttribute("address") String ipAddress, Map<String, Object> map)
			throws IpAddressServiceException, IpStatusListServiceException {

		try {
			if (IpValidator.isIpV4(ipAddress)) {
				return deleteIpFromDataBase(
						ipAddressService.deleteIpByAddress(ipAddress),
						ipAddress, map);
			}
			if (IpValidator.isIpV6(ipAddress)) {
				return deleteIpFromDataBase(
						ipAddressService.deleteIpByAddress(ipAddress),
						ipAddress, map);
			}
			map.put("incorrectMsg", "Incorrect IP-address!");
			return "result";

		} catch (IpAddressServiceException e) {
			map.put("errorList", ExceptionUtil.createErrorList(e));
			map.put("errorMsg", e.getMessage());
			return "result";
		}
	}

	// delete IP from DB
	private String deleteIpFromDataBase(boolean flag, String ipAddress,
			Map<String, Object> map) throws IpStatusListServiceException {
		if (flag) {
			map.put("successMsg", "IP-address: " + ipAddress
					+ " has been successfully deleted.");
			return "result";
		}
		map.put("incorrectMsg", "Current IP-address don't exist");
		return "result";
	}

	// Add IP-address to WhiteList
	@RequestMapping(value = "admin_addIpToList", method = RequestMethod.GET)
	public String addIpToWhiteList() {
		return "admin_addIpToList";
	}

	// Add IP-address to WhiteList
	@RequestMapping(value = "admin_addIpToList", method = RequestMethod.POST)
	public String addIpToWhiteList(@ModelAttribute("address") String ipAddress,
			@ModelAttribute("listType") int listType, Map<String, Object> map)
			throws IpAddressServiceException {
		try {
			String result = addIpToDataBase(
					ipAddressService.saveIpByStatus(ipAddress, listType),
					ipAddress, listType, map);
			// map.put("incorrectMsg", "Incorrect IP-address!");
			return "result";

		} catch (IpStatusListServiceException e) {
			map.put("errorList", ExceptionUtil.createErrorList(e));
			map.put("errorMsg", e.getMessage());
			return "result";
		}
	}
	// add IP to DB
	private String addIpToDataBase(boolean flag, String ipAddress,
			int listType, Map<String, Object> map)
			throws IpStatusListServiceException {
		System.out.println(flag + " FLAGGGG");
		if (flag) {
			map.put("successMsg", "IP-address: " + ipAddress
					+ " has been successfully added.");
			return "result";
		}
		map.put("incorrectMsg", "Current IP-address exist");
		return "result";
	}

	// Show IP-address from WhiteList
	@RequestMapping(value = "secure_showIpListFromWL", method = RequestMethod.GET)
	public String showIpListFromWhiteList() {
		return "secure_showIpListFromWL";
	}

	@RequestMapping(value = "secure_showIpListFromWL", method = RequestMethod.POST)
	public String showIpListFromWhiteList(
			@ModelAttribute("pageNumber") int page,
			@ModelAttribute("countIpPerPage") int value,
			@ModelAttribute("ipType") int ipType, Map<String, Object> map) {
		try {
			List<IpAddress> list = new ArrayList<IpAddress>();
			list.addAll(ipStatusListService.findIpList((page - 1) * value,
					value, ipType, 1));
			map.put("ipList", list);

		} catch (IpStatusListServiceException e) {
			map.put("errorList", ExceptionUtil.createErrorList(e));
			map.put("errorMsg", e.getMessage());
			return "result";
		}
		return "secure_table";
	}

	// test Black List
	@RequestMapping(value = "secure_showIpListFromBL", method = RequestMethod.GET)
	public String showIpListFromBlackList() {
		return "secure_showIpListFromBL";
	}

	@RequestMapping(value = "secure_showIpListFromBL", method = RequestMethod.POST)
	public String showIpListFromBlackList(
			@ModelAttribute("pageNumber") int page,
			@ModelAttribute("countIpPerPage") int value,
			@ModelAttribute("ipType") int ipType, Map<String, Object> map) {
		System.out.println("PAGE "+page+ " COUNT "+value+ "Iptype "+ipType+" ");
		try {
			
			List<IpAddress> list = new ArrayList<IpAddress>();
			list.addAll(ipStatusListService.findIpList((page - 1) * value,
					value,ipType, 0));
			map.put("ipList", list);

		} catch (IpStatusListServiceException e) {
			map.put("errorList", ExceptionUtil.createErrorList(e));
			map.put("errorMsg", e.getMessage());
			return "result";
		}
		return "secure_table";
	}
}