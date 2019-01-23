package com.teamproject.db.Interface;

import com.teamproject.bean.Participant;
import com.teamproject.bean.Route;
import com.teamproject.bean.User;


public interface ParticipantDAOinterface {
    int createParticipant(Route route, User user);
    void updateParticipant(int id, int route_id, int user_id);
    void deleteParticipant();
    void deleteParticipantById(int id);
}
