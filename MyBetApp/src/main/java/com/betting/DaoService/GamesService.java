package com.betting.DaoService;

import com.betting.MyBet.Model.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GamesService {

    private Configuration con;
    private SessionFactory sessionFactory;
    private Session session;

    public GamesService(){
        con = new Configuration().configure().addAnnotatedClass(Ticket.class);
        sessionFactory = con.buildSessionFactory();
        session = sessionFactory.openSession();

    }

    public int getLastId(){

        Ticket ticket =  (Ticket) session.createQuery("select g from SoccerGame g ORDER BY g.gameId DESC").setMaxResults(1)
                .uniqueResult();

        return ticket.getTicketId();
    }

}
