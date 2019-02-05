/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monteiro.monitor.repository;

import com.monteiro.monitor.model.Hashtag;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author vicente.monteiro
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class HashtagRepoIT {

    @Autowired
    private HashtagRepo repo;

    @Test
    public void testInsert() {
        assertNotNull(this.repo.save(new Hashtag("Brasil")).getId());
    }

}
