/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.atos.wl.odc.techhub.business.service.TopicService;
import net.atos.wl.odc.techhub.business.service.UserService;
import net.atos.wl.odc.techhub.common.dto.TopicDto;
import net.atos.wl.odc.techhub.common.dto.UserDto;

/**
 * Spring REST Controller for exposing Export APIs.
 * 
 * @author a120065
 */
@Controller
@Api(value = "/api/export", tags = "Export API")
public class ExportController {

    private static Logger log = LoggerFactory.getLogger(ExportController.class);

    @Autowired
    private TopicService topicService;

    @Autowired
    private UserService userService;

    /**
     * REST service to export the attendance.
     * 
     * @return ResponseEntity with attendance and HTTP status.
     */
    @RequestMapping(value = "/api/export/attendance", method = RequestMethod.GET)
    @ApiOperation(value = "Export topic wise attendance sheet for manual attendance.")
    public ModelAndView exportAttendance() {
        log.info("Exporting attendance excel.");
        final Map<String, List<UserDto>> attendance = new HashMap<>();
        final List<TopicDto> topics = this.topicService.findAllTopics();
        for (final TopicDto topic : topics) {
            attendance.put(topic.getName(), this.userService.findUsersByTopic(topic.getId()));
        }
        return new ModelAndView("excelView", "attendance", attendance);
    }
}
