package com.betting.DaoService;

import com.betting.MyBet.Model.Player;
import com.betting.MyBet.Model.Ticket;
import com.betting.MyBet.Model.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private Configuration con;
    private SessionFactory sessionFactory;
    private Session session;

    public TicketService(){
        con = new Configuration().configure().addAnnotatedClass(Ticket.class);
        sessionFactory = con.buildSessionFactory();
        session = sessionFactory.openSession();

    }

    public void save(Ticket ticket){

        session.getTransaction().begin();
        session.save(ticket);
        session.getTransaction().commit();

    }

    public void update(Ticket ticket){

        session.getTransaction().begin();
        session.update(ticket);
        session.getTransaction().commit();

    }

    public Ticket getTicketByPlayer(Player player){
        Ticket ticket;

        ticket = (Ticket) session.createQuery(
                "SELECT t FROM ticket t where t.playerr=:playerr")
                .setParameter("playerr",player).setMaxResults(1).getSingleResult();

        return ticket;

    }

    public int getLastId(){

        Ticket ticket =  (Ticket) session.createQuery("select t from ticket t ORDER BY t.ticketId DESC").setMaxResults(1)
                .uniqueResult();

        return ticket.getTicketId();
    }


    public void open(){
        if(session == null){
            session = sessionFactory.openSession();
            System.out.println("Session is null, opening session!");

        }

    }
    public void close(){
        if(session != null){
            session.close();
            System.out.println("Session is not null, closing session!");
        }


    }


}
