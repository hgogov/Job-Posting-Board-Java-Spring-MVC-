package com.company.jobs.controller;

import com.company.jobs.dto.JobDTO;
import com.company.jobs.dto.SearchDTO;
import com.company.jobs.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;
    private final CategoryService categoryService;
    private final LocationService locationService;
    private final JobTypeService jobTypeService;
    private final JobExperienceLevelService jobExperienceLevelService;
    private final CompanyService companyService;


    @Autowired
    public JobController(JobService jobService, CategoryService categoryService, LocationService locationService, JobTypeService jobTypeService, JobExperienceLevelService jobExperienceLevelService, CompanyService companyService) {
        this.jobService = jobService;
        this.categoryService = categoryService;
        this.locationService = locationService;
        this.jobTypeService = jobTypeService;
        this.jobExperienceLevelService = jobExperienceLevelService;
        this.companyService = companyService;
    }

    @GetMapping
    public String findAll(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {

        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        Page<JobDTO> allJobs = jobService.findAllPaginated(PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("totalElements", allJobs.getTotalElements());
        model.addAttribute("jobs", allJobs);
        model.addAttribute("searchJob", new SearchDTO());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("locations", locationService.findAll());
        model.addAttribute("types", jobTypeService.findAll());
        model.addAttribute("experienceLevels", jobExperienceLevelService.findAll());
        return "jobs/index";
    }

    @GetMapping("/details/{id}")
    public String findById(@PathVariable Long id, Model model) {

        JobDTO foundJob = jobService.findById(id);
        model.addAttribute("job", foundJob);
        return "jobs/details";
    }

    @GetMapping("/create")
    public String create(Model model) {

        model.addAttribute("job", new JobDTO());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("locations", locationService.findAll());
        model.addAttribute("types", jobTypeService.findAll());
        model.addAttribute("experienceLevels", jobExperienceLevelService.findAll());
        model.addAttribute("companies", companyService.findAll());
        return "jobs/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("job") @Valid JobDTO jobDTO, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("job", jobDTO);
            model.addAttribute("categories", categoryService.findAll());
            model.addAttribute("locations", locationService.findAll());
            model.addAttribute("types", jobTypeService.findAll());
            model.addAttribute("experienceLevels", jobExperienceLevelService.findAll());
            model.addAttribute("companies", companyService.findAll());
            return "jobs/create";
        }

        jobService.create(jobDTO);
        model.addAttribute("success", "Job successfully posted.");
        return "redirect:/jobs/create";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        JobDTO jobDTO = jobService.findById(id);
        model.addAttribute("job", jobDTO);
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("locations", locationService.findAll());
        model.addAttribute("types", jobTypeService.findAll());
        model.addAttribute("experienceLevels", jobExperienceLevelService.findAll());
        model.addAttribute("companies", companyService.findAll());
        model.addAttribute("id", id);
        return "jobs/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, @Valid @ModelAttribute("job") JobDTO jobDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories", categoryService.findAll());
            model.addAttribute("locations", locationService.findAll());
            model.addAttribute("types", jobTypeService.findAll());
            model.addAttribute("experienceLevels", jobExperienceLevelService.findAll());
            model.addAttribute("companies", companyService.findAll());
            model.addAttribute("id", id);
            return "jobs/edit";
        }

        jobService.updateById(id, jobDTO);
        return "redirect:/jobs/details/" + id;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {

        model.addAttribute("job", jobService.findById(id));
        return "jobs/delete";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {

        jobService.delete(id);
        return "redirect:/jobs";
    }

    @GetMapping("/search")
    public String search(@ModelAttribute("job") SearchDTO searchDTO, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size, Model model) {

        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);

        Page<JobDTO> foundJobs = jobService.searchPaginated(PageRequest.of(currentPage - 1, pageSize), searchDTO);
        model.addAttribute("totalElements", foundJobs.getTotalElements());
        model.addAttribute("jobs", foundJobs);
        model.addAttribute("searchJob", new SearchDTO());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("locations", locationService.findAll());
        model.addAttribute("types", jobTypeService.findAll());
        model.addAttribute("experienceLevels", jobExperienceLevelService.findAll());
        return "jobs/index";
    }
}
