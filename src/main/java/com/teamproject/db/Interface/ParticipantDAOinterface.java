package com.teamproject.db.Interface;

import com.teamproject.bean.Participant;
import java.util.ArrayList;
import java.util.HashMap;

public interface ParticipantDAOinterface {
    public int createParticipant(int routeid, int userid);
    public int deleteParticipant(int routeid, int userid);
    public HashMap<Integer, Participant> selectAllParticipants();
    public HashMap<Integer, Participant> getParticipantfromQuery(String query);
    public Participant getParticipantById(int id);
    public ArrayList<Integer> selectParticipantById(int id);
    public boolean checkParticipant(int routeId, int userId);
}
