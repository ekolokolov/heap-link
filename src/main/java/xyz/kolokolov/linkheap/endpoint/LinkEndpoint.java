package xyz.kolokolov.linkheap.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.kolokolov.linkheap.model.Link;
import xyz.kolokolov.linkheap.repo.LinkRepository;
import xyz.kolokolov.linkheap.repo.impl.LinkRepositoryImpl;

import java.util.List;

@RestController
@RequestMapping("{channel}")
public class LinkEndpoint {

    private final LinkRepository repository;

    @Autowired
    public LinkEndpoint(LinkRepositoryImpl repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Link> getAll(@PathVariable String channel) {
        return repository.getAllByChannel(channel);
    }

    @PostMapping
    public Link add(@PathVariable String channel, @RequestBody Link link) {
        return repository.add(channel, link);
    }

}
