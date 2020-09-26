/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brewery.src.controller;

import brewery.src.model.Beers;
import brewery.src.model.Categories;
import brewery.src.model.DBUtil;
import brewery.src.model.Styles;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Service;

/**
 *
 * @author Brendan
 */
@Service
public class beerService {

    // static List<Beers> beerList = new ArrayList();
    public List<Beers> getAllBeers() {
        EntityManager em = DBUtil.getEMF().createEntityManager();

        List<Beers> list = null;

        try {
            list = em.createNamedQuery("Beers.findAll", Beers.class)
                    .getResultList();
            if (list == null || list.isEmpty()) {
                list = null;
            }

        } finally {
            em.close();
        }
        return list;

    }


    public List<Beers> Search(String searchName) {
        EntityManager em = DBUtil.getEMF().createEntityManager();
        List<Beers> list = null;

        try {
            list = em.createNamedQuery("Beers.findByName", Beers.class)
                    .setParameter("name", searchName)
                    .getResultList();
            if (list == null || list.isEmpty()) {
                list = null;
            }

        } finally {
            em.close();
        }
        return list;
    }



    public Beers GetBeerByID(int id) {
        EntityManager em = DBUtil.getEMF().createEntityManager();
     Beers beer = null;
       try{
           beer = em.createNamedQuery("Beers.findById", Beers.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }


        return beer;
    }


    public boolean Update(Beers beer) {
        EntityManager em = DBUtil.getEMF().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        Date date = new Date();

//        brewerie.setId(brewerie.getId());
        beer.setImage("no_image.jpg");

        try {

            trans.begin();
            em.merge(beer);
            trans.commit();


        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }
        return true;
    }
    public Categories getCatagoryByCatID(int catId){
          EntityManager em = DBUtil.getEMF().createEntityManager();
       Categories cat = null;
       try{
           cat = em.createNamedQuery("Categories.findById", Categories.class)
                    .setParameter("id", catId)
                    .getSingleResult();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }
        return cat;
       
    }
        public Styles getStylesByStyleID(int styleId){
          EntityManager em = DBUtil.getEMF().createEntityManager();
       Styles Style = null;
       try{
           Style = em.createNamedQuery("Styles.findById", Styles.class)
                    .setParameter("id", styleId)
                    .getSingleResult();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }
        return Style;
       
    }
}
