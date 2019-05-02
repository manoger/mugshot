package hive.mugshot.controller;

import hive.mugshot.exception.NotAcceptedFileFormatException;
import hive.mugshot.storage.ImageStorer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

import static hive.mugshot.storage.ImageUtils.validateIfHasAnImageAsExtension;
import static hive.pandora.constant.HiveInternalHeaders.AUTHENTICATED_USER_ID;

@RestController
@RequestMapping("/")
public class MugshotController {

  @Value("${hive.mugshot.profile-image-name}")
  private String imageName;
  private final ImageStorer imageStorer;

  @Autowired
  public MugshotController(ImageStorer imageStorer) {
    this.imageStorer = imageStorer;
  }

  @ResponseStatus(code = HttpStatus.OK, reason = "Profile image successfully stored")
  @PostMapping
  public void sendImageProfile(
      @RequestParam("image") MultipartFile insertedImage,
      @RequestHeader(name = AUTHENTICATED_USER_ID) final String userId
  ){
    if(!validateIfHasAnImageAsExtension(insertedImage.getOriginalFilename())) {
      throw new NotAcceptedFileFormatException();
    }
    imageStorer.storeImageProfile(userId,insertedImage,imageName);
  }

  @GetMapping(produces = MediaType.IMAGE_JPEG_VALUE)
  public ResponseEntity<Resource> searchProfileImage(
      @RequestHeader(name = AUTHENTICATED_USER_ID) final String userId
  ){
    Resource file = imageStorer.loadImage(userId,imageName);
    return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
  }

  @ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Profile image successfully deleted")
  @DeleteMapping
  public void deleteProfileImage(
      @RequestHeader(name = AUTHENTICATED_USER_ID) final String userId
  ){
    imageStorer.deleteImage(userId,imageName);
  }

}
