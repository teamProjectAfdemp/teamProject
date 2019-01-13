package com.teamproject.db;


public interface ParticipantDAOinterface {
    void createParticipant(int route_id, int user_id);
    void updateParticipant(int id, int route_id, int user_id);
    void deleteParticipant();
    void deleteParticipantById(int id);
}
