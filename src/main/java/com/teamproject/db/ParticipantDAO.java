package com.teamproject.db;

import com.teamproject.bean.Participant;
import com.teamproject.bean.Route;
import com.teamproject.db.Interface.ParticipantDAOinterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;

@Controller
public class ParticipantDAO extends Database implements ParticipantDAOinterface{

    public static ParticipantDAO participantDAO = null;

    private ParticipantDAO() {
    }

    public static ParticipantDAO getInstance() {
        if (participantDAO == null) {
            participantDAO = new ParticipantDAO();
        }
        return participantDAO;
    }

    
    @Override
    public int createParticipant(Participant participant) {
        Connection conn = createConnection();
        PreparedStatement prest = null;
        int rowsInserted = 0;
        String query =  "INSERT INTO `Participants` (`route_id`,`user_id`)"+
                        "VALUES (?,?);";
        try {
            prest = conn.prepareStatement(query);
            prest.setInt(1,participant.getRoute_id());
            prest.setInt(2,participant.getUser_id());
            rowsInserted = prest.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsInserted;
    }

    @Override
    public void updateParticipant(int id, int route_id, int user_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteParticipant() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteParticipantById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public HashMap<Integer, Participant> selectAllParticipants() {
        String query = "SELECT * FROM `teamproject`.`Participants`;";
        return getParticipantfromQuery(query);
    }
    
    public HashMap<Integer, Participant> getParticipantfromQuery(String query) {

        Collection<Map<String, Object>> answer = new ArrayList<>();
        answer = getGenericSelect(query);

        HashMap<Integer, Participant> participantFound = new HashMap<>();

        for (Map<String, Object> row : answer) {
            Participant participant = new Participant();
            participant.setId((Integer) row.get("id"));
            participant.setRoute_id((Integer) row.get("route_id"));
            participant.setUser_id((Integer) row.get("user_id"));
            participantFound.put(participant.getId(), participant);
        }
        return participantFound;
    }    
    
    
    public HashMap<Integer, Participant> selectAllparticipants() {
        String query = "SELECT * FROM `teamproject`.`Participants`;";
        return getParticipantfromQuery(query);
    }
    
    public Participant getParticipantById(int id) {
        Participant participant = new Participant();

        String query = ("SELECT * FROM `teamproject`.`Participants` WHERE `id` = '" + id + "';");

        Collection<Map<String, Object>> answer;
        answer = getGenericSelect(query);

        for (Map<String, Object> row : answer) {
            participant.setId((Integer) row.get("id"));
            participant.setRoute_id((Integer) row.get("route_id"));
            participant.setUser_id((Integer) row.get("user_id"));
            
            System.out.println(row.get("id"));
            System.out.println("ONE MORE Participant");
        }
        System.out.println(participant.getId());

        return participant;
    }

    public int updateParticipant(Participant participant) {

        String query = "UPDATE `teamproject`.`Participants` SET `route_id` = '" + participant.getRoute_id()
                + "' ,`user_id` = '" + participant.getUser_id() + "';";

        System.out.println(query);
        return execUpdateInsert(query);

    }
    
    public int deleteParticipant(Participant participant) {

        String query = "DELETE FROM `teamproject`.`Participants` WHERE `id` = '" + participant.getId() + "';";

        System.out.println(query);
        return execUpdateInsert(query);
    }
    
    public Participant selectParticipantById(int id){
        
        String query = "SELECT * FROM `teamproject`.`Participants` WHERE `id` = '" + id +"';";
        
        Collection<Map<String, Object>> answer;
        answer = getGenericSelect(query);
        
        Participant participant =  new Participant();
        
        for (Map<String, Object> row : answer) {
            participant.setId((Integer) row.get("id"));
            participant.setRoute_id((Integer) row.get("route_id"));
            participant.setUser_id((Integer) row.get("user_id"));
        }
        
        return participant;
    }
    
}
