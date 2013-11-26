package tc.lv.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tc.lv.domain.IpAddress;
import tc.lv.domain.PaginationSettings;
import tc.lv.exceptions.IpAddressServiceException;
import tc.lv.exceptions.IpStatusListServiceException;
import tc.lv.service.IpAddressService;
import tc.lv.service.IpStatusListService;
import tc.lv.service.PaginationService;
import tc.lv.service.implementation.PaginationServiceImpl;
import tc.lv.utils.ExceptionUtil;
import tc.lv.utils.IpValidator;

@Controller
public class ListController {

	@Autowired
	private IpStatusListService ipStatusListService;

	@Autowired
	private IpAddressService ipAddressService;

	@Autowired
	private PaginationService paginationService;

	private static final Logger LOGGER = Logger.getLogger(ListController.class);

	@RequestMapping(value = "admin_deleteIpFromList", method = RequestMethod.GET)
	public String deleteIpFromWhiteList() {
		return "admin_deleteIpFromList";
	}

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

	@RequestMapping(value = "admin_addIpToList", method = RequestMethod.GET)
	public String addIpToWhiteList() {
		return "admin_addIpToList";
	}

	@RequestMapping(value = "admin_addIpToList", method = RequestMethod.POST)
	public String addIpToWhiteList(@ModelAttribute("address") String ipAddress,
			@ModelAttribute("listType") String listType, Map<String, Object> map)
			throws IpAddressServiceException {
		try {
			String result = addIpToDataBase(
					ipAddressService.saveIpByStatus(ipAddress, listType),
					ipAddress, listType, map);
			return "result";

		} catch (IpStatusListServiceException e) {
			map.put("errorList", ExceptionUtil.createErrorList(e));
			map.put("errorMsg", e.getMessage());
			return "result";
		}
	}

	private String addIpToDataBase(boolean flag, String ipAddress,
			String listType, Map<String, Object> map)
			throws IpStatusListServiceException {
		if (flag) {
			map.put("successMsg", "IP-address: " + ipAddress
					+ " has been successfully added.");
			return "result";
		}
		map.put("incorrectMsg", "Current IP-address exist");
		return "result";
	}

	@RequestMapping(value = "secure_showIpListFromWL", method = RequestMethod.GET)
	public String showIpListFromWhiteList(Map<String, Object> map) {
		map.put("pageList", paginationService.loadPages());
		return "secure_showIpListFromWL";
	}

	@RequestMapping(value = "secure_showIpListFromWL", method = RequestMethod.POST)
	public String showIpListFromWhiteList(
			@ModelAttribute("pageNumber") int pageNumber,
			@ModelAttribute("countIpPerPage") int countIpPerPage,
			@ModelAttribute("ipType") String ipType, Map<String, Object> map) {
		try {
			int ipCount;
			int pageCount;
			List<PaginationSettings> pageList = paginationService.loadPages();

			List<IpAddress> list = new ArrayList<IpAddress>();
			list.addAll(ipStatusListService.findIpList((pageNumber - 1)
					* countIpPerPage, countIpPerPage, ipType, "whiteList"));
			ipCount = list.size();
			pageCount = ipCount / countIpPerPage + 1;
			pageList = paginationService.loadPages();
			map.put("ipList", list);
			map.put("pageList", pageList);
			map.put("pageCount", pageCount);
			
		} catch (IpStatusListServiceException e) {
			map.put("errorList", ExceptionUtil.createErrorList(e));
			map.put("errorMsg", e.getMessage());
			return "result";
		}
		return "secure_table";
	}

	@RequestMapping(value = "secure_showIpListFromBL", method = RequestMethod.GET)
	public String showIpListFromBlackList(Map<String, Object> map) {
		map.put("pageList", paginationService.loadPages());
		return "secure_showIpListFromBL";
	}

	@RequestMapping(value = "secure_showIpListFromBL", method = RequestMethod.POST)
	public String showIpListFromBlackList(
			@ModelAttribute("pageNumber") int pageNumber,
			@ModelAttribute("countIpPerPage") int countIpPerPage,
			@ModelAttribute("ipType") String ipType, Map<String, Object> map) {
		try {
			int ipCount;
			int pageCount;
			List<PaginationSettings> pageList = paginationService.loadPages();

			List<IpAddress> list = new ArrayList<IpAddress>();
			list.addAll(ipStatusListService.findIpList((pageNumber - 1)
					* countIpPerPage, countIpPerPage, ipType, "blackList"));
			ipCount = list.size();
			pageCount = ipCount / countIpPerPage + 1;
			pageList = paginationService.loadPages();
			map.put("ipList", list);
			map.put("pageList", pageList);
			map.put("pageCount", pageCount);			
		} catch (IpStatusListServiceException e) {
			map.put("errorList", ExceptionUtil.createErrorList(e));
			map.put("errorMsg", e.getMessage());
			return "result";
		}
		return "secure_table";
	}
}