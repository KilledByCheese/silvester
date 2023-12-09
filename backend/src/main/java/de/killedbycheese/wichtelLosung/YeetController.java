package de.killedbycheese.wichtelLosung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("yeet")
public class YeetController {
	
	
	private YeetService yeetService;
	
	@Autowired
	public YeetController(YeetService yeetService) {
		this.yeetService = yeetService;
	}

	
	@GetMapping("/{name}")
	public String yeet(@PathVariable String name) {
		return yeetService.yoot(name.toLowerCase());
	}
}
