package lab4.library.controller;

import lab4.library.publisher.Publisher;
import lab4.library.service.PublisherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/publisher")
public class PublisherController {

    private static final Logger LOG = LoggerFactory.getLogger(PublisherController.class);

    @Autowired
    private PublisherService publisherService;

    @GetMapping(value = "/getsearchingbypublisherform")
    public String getSearchingByPublisherForm() {
        LOG.info("msg: ");
        return "publisher/searchingform";
    }

    @PostMapping(value = "/searchingbypublisher")
    public String searchByPublisher(@RequestParam String publisherName, Model model) {
        LOG.info("msg: Publisher publisher = publisherService.findByPublisherName(publisherName);", publisherName);
        Publisher publisher = publisherService.findByPublisherName(publisherName);
        if (publisher != null) {
            LOG.info("msg: if (publisher != null) {  model.addAttribute(\"books\", publisher.getBooks()); }");
            model.addAttribute("books", publisher.getBooks());
        } else {
            LOG.info("msg: model.addAttribute(\"error\", \"Sorry, books by publisher \" + publisherName + \" a not found.\");", publisherName);
            model.addAttribute("error", "Sorry, books by publisher " + publisherName + " a not found.");
            model.addAttribute("bookName", "");
        }
        LOG.info("msg: return \"book/showallbooks\";");
        return "book/showallbooks";
    }
}
