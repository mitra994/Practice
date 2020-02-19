package com.betting.DaoService;

import com.betting.MyBet.Model.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private Configuration con;
    private SessionFactory sessionFactory;
    private Session session;

    public UserService(){
        con = new Configuration().configure().addAnnotatedClass(Player.class);
        sessionFactory = con.buildSessionFactory();


    }

    public void save(Player player){
        session = getSession();
        session.getTransaction().begin();
        session.save(player);
        session.beginTransaction().commit();


    }

    public void merge(Player player){
        session = getSession();
        session.getTransaction().begin();
        session.merge(player);

        session.beginTransaction().commit();

    }

    public void update(Player player){
        session = getSession();
        session.getTransaction().begin();
        session.update(player);
        session.getTransaction().commit();


    }

    public Player getPlayerByUsername(String username){
        session = getSession();
        session.getTransaction().begin();
        Player player;

        player = (Player) session.createQuery(
                "SELECT p FROM player p where p.username=:username")
                .setParameter("username",username).getSingleResult();
        session.getTransaction().commit();

        return player;

    }


    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }


}
