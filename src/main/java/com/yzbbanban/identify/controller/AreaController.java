package com.yzbbanban.identify.controller;

import com.yzbbanban.identify.entity.Area;
import com.yzbbanban.identify.service.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by brander on 2018/3/1
 */
@RestController
@RequestMapping("/superAdmin")
public class AreaController {
    @Autowired
    private IAreaService iAreaService;

    @RequestMapping(value = "getAreaList", method = RequestMethod.GET)
    public Map<String, Object> getAreaList() {
        List<Area> areas = iAreaService.getAreaList();
        Map<String, Object> map = new HashMap<>();
        map.put("areaList", areas);
        return map;
    }

    @RequestMapping(value = "getAreaById", method = RequestMethod.GET)
    public Map<String, Object> getAreaById(int areaId) {
        Area area = iAreaService.getAreaById(areaId);
        Map<String, Object> map = new HashMap<>();
        map.put("area", area);
        return map;
    }

    @RequestMapping(value = "addAreaById", method = RequestMethod.POST)
    public Map<String, Object> addAreaById(@RequestBody Area area) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", iAreaService.addAreaById(area));
        return map;
    }

    @RequestMapping(value = "modifyArea", method = RequestMethod.POST)
    public Map<String, Object> modifyArea(@RequestBody Area area) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", iAreaService.modifyArea(area));
        return map;
    }

    @RequestMapping(value = "deleteAreaById", method = RequestMethod.POST)
    public Map<String, Object> deleteAreaById(int areaId) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", iAreaService.deleteAreaById(areaId));
        return map;
    }
}
