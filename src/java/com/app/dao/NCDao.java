/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.dao;

import com.app.model.NC;
import java.util.List;

/**
 *
 * @author roman
 */
public interface NCDao {
    NC findById(int id);
    List<NC> findAll();
}

