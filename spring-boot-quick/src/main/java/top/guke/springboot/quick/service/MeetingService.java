package top.guke.springboot.quick.service;


import org.springframework.stereotype.Service;
import top.guke.springboot.quick.entiy.Meeting;


import java.util.ArrayList;
import java.util.List;

@Service
public class MeetingService {
    private final List<Meeting> meetings=new ArrayList<>();

    public boolean isRoomAvailable(Meeting newMeeting){
        return meetings.stream()
                .noneMatch(exitingMeeting -> exitingMeeting.isOverlapping(newMeeting));
    }

    public void addMeeting(Meeting meeting){
        meetings.add(meeting);
    }
}
