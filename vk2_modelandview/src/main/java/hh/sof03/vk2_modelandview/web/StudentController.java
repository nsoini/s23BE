package hh.sof03.vk2_modelandview.web;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hh.sof03.vk2_modelandview.domain.Student;
import hh.sof03.vk2_modelandview.domain.Friend;

@Controller
public class StudentController {
	
	@GetMapping("/hello21")
	public String checkAge2(Model model, @RequestParam (name="name") String name, @RequestParam(name="age") int age) {
		System.out.println("age check");
		model.addAttribute("age", age);
		model.addAttribute("name", name);
		return "agecheck";	
	}
	
	@GetMapping("/hello22")
	public String showStudents(Model model) {
		System.out.println("student");
		List<Student> students = new ArrayList<>();
		students.add(new Student("Anna","Testaaja"));
		students.add(new Student("Anne","Test"));
		students.add(new Student("Anni","Test-Test"));
		
		model.addAttribute("students", students);
		
		return "studentlist23";
	}
		
	List<Friend> friends = new ArrayList<>();
	
	@GetMapping("/index")
	public String listFriends(Model model) {
		System.out.println("list friends");
		
		model.addAttribute("friend", new Friend());
		model.addAttribute("friends", friends);
		
		return "index";
	}
	
	@PostMapping("/addFriend")
	public String addFriend(@ModelAttribute Friend friend, Model model) {
		System.out.println("add friends");
		
		friends.add(friend);
		model.addAttribute("friend", friend);
		
		return "redirect:/index";
	}
		
	
}
