package chapter2.web;

import chapter2.service.posts.PostsService;
import chapter2.web.dto.PostsResponseDto;
import chapter2.web.dto.PostsSaveRequestDto;
import chapter2.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class PostsApiController {

   private final PostsService postsService;

   @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
       return postsService.save(requestDto);
   }

   @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
       System.out.println(id);
       System.out.println(requestDto.getTitle());
       System.out.println(requestDto.getContent());
       return postsService.update(id, requestDto);
   }

   @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findbyId(@PathVariable Long id){
       return postsService.findById(id);
   }
   @DeleteMapping("/api/v1/posts/{id}")
   public Long delete(@PathVariable Long id){
      postsService.delete(id);
      return id;
   }
}
