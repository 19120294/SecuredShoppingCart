package com.KLBproject.KLB_project.service.Image;



import com.KLBproject.KLB_project.dto.ImageDto;
import com.KLBproject.KLB_project.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IImageService {
    Image getImageById(Long id);
    void deleteImageById(Long id);
    List<ImageDto> saveImages(Long productId, List<MultipartFile> files);
    void updateImage(MultipartFile file,  Long imageId);
}