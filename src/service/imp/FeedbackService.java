/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.imp;

import java.util.List;
import model.Feedback;
import model.User;
import repository.IFeedbackRepository;
import repository.imp.FeedbackRepository;
import service.IFeedbackService;

/**
 *
 * @author TechCare
 */
public class FeedbackService implements IFeedbackService{
    private IFeedbackRepository feedbackRepo = new FeedbackRepository();

    @Override
    public List<Feedback> showList() {
        return feedbackRepo.showList();
    }

    @Override
    public boolean addFeedback(Feedback f, User user) {
        return feedbackRepo.addFeedback(f, user);
    }

    @Override
    public boolean delFeedback(int id) {
        return feedbackRepo.delFeedback(id);
    }

    @Override
    public Feedback findById(int id) {
        return feedbackRepo.findById(id);
    }
    
}
