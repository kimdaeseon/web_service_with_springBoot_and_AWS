package chapter2.service.posts;

import chapter2.domain.posts.Posts;
import chapter2.domain.posts.PostsRepository;
import chapter2.web.dto.PostsResponseDto;
import chapter2.web.dto.PostsSaveRequestDto;
import chapter2.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        System.out.println(id);
        System.out.println(requestDto.getTitle());
        System.out.println(requestDto.getContent());

        posts.update(requestDto.getTitle(), requestDto.getContent());


        return id;
    }
    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }
}
