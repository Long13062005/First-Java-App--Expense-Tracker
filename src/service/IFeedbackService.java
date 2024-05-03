/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import repository.*;
import java.util.List;
import model.Feedback;
import model.User;

/**
 *
 * @author TechCare
 */
public interface IFeedbackService {
    List<Feedback> showList();
    boolean addFeedback(Feedback f,User user);
    boolean delFeedback(int id);
        Feedback findById(int id);

    
}
