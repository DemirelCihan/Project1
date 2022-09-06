package com.example.demo.api.controllers;

import com.example.demo.business.abstracts.ViewerService;
import com.example.demo.core.results.DataResult;
import com.example.demo.core.results.Result;
import com.example.demo.entities.concretes.Viewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/viewers")
@CrossOrigin
public class ViewersController {
private ViewerService viewerService;
@Autowired
    public ViewersController(ViewerService viewerService){
    this.viewerService = viewerService;
}

@PutMapping("/update")
public Result update(@RequestBody Viewer viewer){
    return viewerService.update(viewer);
}

@GetMapping("/getById")
public DataResult<Viewer> getById(@RequestParam int id){
    return viewerService.getById(id);

}
@PutMapping("/activate")
    public Result activate(@RequestParam String code){
    return viewerService.activate(code);
}

}
