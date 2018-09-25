/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.business.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.atos.wl.odc.techhub.business.mapper.ObjectMapper;
import net.atos.wl.odc.techhub.common.dto.AttendanceDto;
import net.atos.wl.odc.techhub.data.dao.AttendanceDAO;
import net.atos.wl.odc.techhub.data.entity.Attendance;

/**
 * Attendance Service Implementation.
 * 
 * @author a120065
 */
@Service
@Transactional
public class AttendanceServiceImpl implements AttendanceService {

    /**
     * Attendance DAO instance that will be initialized by spring using
     * constructor injection.
     */
    @Autowired
    private AttendanceDAO attendanceDAO;

    /**
     * Dozer object mapper.
     */
    @Autowired
    private ObjectMapper objectMapper;

    /*
     * (non-Javadoc)
     * 
     * @see
     * net.atos.wl.odc.techhub.business.service.AttendanceService#markAttendance
     * (java.lang.String)
     */
    @Override
    public void markAttendance(final String userId) {
        this.getAttendanceDAO().markAttendance(userId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.atos.wl.odc.techhub.business.service.AttendanceService#
     * getAttendanceByRoomNumber(net.atos.wl.odc.techhub.common.enums.
     * RoomNumber)
     */
    @Override
    public List<AttendanceDto> getAttendance() {

        // First fetch all attendances by invoking DAO.
        final List<Attendance> attendances = this.getAttendanceDAO().getAttendance();

        // If attendances are found them iterate through the list and map all
        // entities to AttendanceDto.
        if (attendances != null && !attendances.isEmpty()) {
            final List<AttendanceDto> attendanceDtos = new ArrayList<>();
            for (final Attendance attendance : attendances) {
                final AttendanceDto attendanceDto = this.getObjectMapper().map(attendance, AttendanceDto.class);
                attendanceDto.setUserId(attendance.getUser().getUserId());
                attendanceDtos.add(attendanceDto);
            }

            return attendanceDtos;
        }

        return new ArrayList<AttendanceDto>();
    }

    /**
     * Getter for attendanceDAO.
     *
     * @return the attendanceDAO
     */
    public final AttendanceDAO getAttendanceDAO() {
        return attendanceDAO;
    }

    /**
     * Setter for attendanceDAO.
     *
     * @param attendanceDAO
     *            the attendanceDAO to set
     */
    public final void setAttendanceDAO(AttendanceDAO attendanceDAO) {
        this.attendanceDAO = attendanceDAO;
    }

    /**
     * Getter for objectMapper.
     *
     * @return the objectMapper
     */
    public final ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    /**
     * Setter for objectMapper.
     *
     * @param objectMapper
     *            the objectMapper to set
     */
    public final void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

}
