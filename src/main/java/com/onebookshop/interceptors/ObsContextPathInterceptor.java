package com.onebookshop.interceptors;

import com.onebookshop.util.PropertiesConfig;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class ObsContextPathInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler, final ModelAndView modelAndView) throws Exception
	{
		if (modelAndView != null && !isIncludeRequest(request) && isSupportedView(modelAndView))
		{
			modelAndView.addObject("contextPath", request.getContextPath());
			modelAndView.addObject("categoryMap", categoryMap());
		}
	}

	protected boolean isIncludeRequest(final HttpServletRequest request)
	{
		return request.getAttribute("javax.servlet.include.request_uri") != null;
	}

	protected boolean isSupportedView(final ModelAndView modelAndView)
	{
		return modelAndView.getViewName() != null && !isRedirectView(modelAndView);
	}

	protected boolean isRedirectView(final ModelAndView modelAndView)
	{
		final String viewName = modelAndView.getViewName();
		return viewName != null && viewName.startsWith("redirect:");
	}

	private Map categoryMap() {
		Map map = new LinkedHashMap();
		for (String cat : PropertiesConfig.getPropertyValue("root.category").split(", ")) {
			Map map1 = new LinkedHashMap();
			List<String> subCatList = new ArrayList<>();
			if(!PropertiesConfig.getPropertyValue("subcategory." + cat).equals("")){
				subCatList = Arrays.asList(PropertiesConfig.getPropertyValue("subcategory." + cat).split(", "));
			}

			List<String> subSubCatList = new ArrayList<>();

			for (String subCat : subCatList) {
				String absSubCatStr = "subcategory." + cat + "." + subCat;
				subSubCatList = Arrays.asList(PropertiesConfig.getPropertyValue(absSubCatStr).split(", "));
				if (subSubCatList.size() > 0) map1.put(subCat, subSubCatList);
			}
			map.put(cat, map1);
		}
		return map;
	}
}
