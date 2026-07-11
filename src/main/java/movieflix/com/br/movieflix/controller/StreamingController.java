package movieflix.com.br.movieflix.controller;


import lombok.RequiredArgsConstructor;
import movieflix.com.br.movieflix.controller.request.StreamingRequest;
import movieflix.com.br.movieflix.controller.response.StreamingResponse;
import movieflix.com.br.movieflix.entity.Streaming;
import movieflix.com.br.movieflix.mapper.StreamingMapper;
import movieflix.com.br.movieflix.service.StreamingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/streaming")
@RequiredArgsConstructor
public class StreamingController {

    private final StreamingService streamingService;

    @GetMapping()
    public ResponseEntity<List<StreamingResponse>> getAll(){
        return ResponseEntity.ok(streamingService.findAll()
                .stream()
                .map(StreamingMapper::toStreamingResponse)
                .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> getById(@PathVariable Long id){
        return streamingService.findById(id)
                .map(category -> ResponseEntity.ok(StreamingMapper.toStreamingResponse(category)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<StreamingResponse> save(@RequestBody StreamingRequest request){
        Streaming newStreaming = StreamingMapper.toStreaming(request);
        Streaming savedStreaming = streamingService.save(newStreaming);
        return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.toStreamingResponse(savedStreaming));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        streamingService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
