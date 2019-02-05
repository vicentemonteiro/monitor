/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monteiro.monitor.bussines;

import com.monteiro.monitor.model.Hashtag;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author vicente.monteiro
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EntryServiceIT {

    @Autowired
    private EntryService service;

    @Test
    public void testGetEntry() {
        assertFalse(service.getEntry(new Hashtag("Brasil")).isEmpty());
    }

}
