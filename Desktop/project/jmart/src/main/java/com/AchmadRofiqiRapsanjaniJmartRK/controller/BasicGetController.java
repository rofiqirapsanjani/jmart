package com.AchmadRofiqiRapsanjaniJmartRK.controller;

import com.AchmadRofiqiRapsanjaniJmartRK.dbjson.JsonTable;
import com.AchmadRofiqiRapsanjaniJmartRK.dbjson.Serializable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface BasicGetController<T extends Serializable> {


    @GetMapping("/page")
    public @ResponseBody List<T> getPage(@RequestParam(defaultValue="1") int page, @RequestParam(defaultValue="5") int pageSize);

    @GetMapping("/{id}")
    public T getById(@PathVariable int id);

    public abstract JsonTable<T> getJsonTable();
}