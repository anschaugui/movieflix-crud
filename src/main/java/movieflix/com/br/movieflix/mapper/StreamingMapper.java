package movieflix.com.br.movieflix.mapper;

import lombok.experimental.UtilityClass;
import movieflix.com.br.movieflix.controller.request.StreamingRequest;
import movieflix.com.br.movieflix.controller.response.StreamingResponse;
import movieflix.com.br.movieflix.entity.Category;
import movieflix.com.br.movieflix.entity.Streaming;

@UtilityClass
public class StreamingMapper {

    public static Streaming toStreaming(StreamingRequest request){
        return Streaming
                .builder()
                .name(request.name())
                .build();
    }

    public static StreamingResponse toStreamingResponse(Streaming streaming){
        return StreamingResponse
                .builder()
                .id(streaming.getId())
                .name(streaming.getName())
                .build();
    }

}
