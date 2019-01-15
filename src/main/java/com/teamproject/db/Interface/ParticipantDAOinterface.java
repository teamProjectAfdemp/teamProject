package com.teamproject.db.Interface;

import com.teamproject.bean.Participant;


public interface ParticipantDAOinterface {
    int createParticipant(Participant participant);
    void updateParticipant(int id, int route_id, int user_id);
    void deleteParticipant();
    void deleteParticipantById(int id);
}
