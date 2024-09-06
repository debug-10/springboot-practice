package top.guke.springboot.quick.controller;


import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.guke.springboot.quick.entiy.Meeting;
import top.guke.springboot.quick.service.MeetingService;


@RestController
@RequestMapping("/meeting")
public class MeetingController {
    @Resource
    private MeetingService meetingService;

    @PostMapping("/check")
    public ResponseEntity<String> check(@RequestBody Meeting meeting){
        if(meetingService.isRoomAvailable(meeting)){
            meetingService.addMeeting(meeting);
            return ResponseEntity.ok("会议室可用！");
        }else {
            return ResponseEntity.ok("会议室已被占用!");
        }
    }
}
