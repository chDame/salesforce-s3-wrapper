package com.cdame.services;

import java.io.InputStream;
import java.util.Arrays;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;

@Service
public class AwsS3Service {


	private AmazonS3 s3client;

	@Value("${amazonProperties.region}")
	private String region;
	@Value("${amazonProperties.accessKey}")
	private String accessKey;
	@Value("${amazonProperties.secretKey}")
	private String secretKey;

	@PostConstruct
	private void initializeAmazon() {
	 	BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKey, secretKey);
	 	this.s3client = AmazonS3ClientBuilder.standard()
	 							.withRegion(region)
	 							.withCredentials(new AWSStaticCredentialsProvider(awsCreds))
	    	                    .build();
	}
	
	private String generateKey(String filename) {
		return UUID.randomUUID().toString() + filename;
	}
	
	public String[] listBuckets() {
		return Arrays.stream(s3client.listBuckets().toArray(new Bucket[0]))
			.map(b -> b.getName()).toArray(size -> new String[size]);
	}

	public String[] listObjects(String bucketName) {
		return Arrays.stream(s3client.listObjects(bucketName).getObjectSummaries().toArray(new S3ObjectSummary[0]))
				.map(o -> o.getKey()).toArray(size -> new String[size]);
	}
	
	public String sendFile(String bucketName, String fileName, InputStream inputStream, long contentLength) {
		ObjectMetadata meta = new ObjectMetadata();
		meta.setContentLength(contentLength);
		String key = generateKey(fileName);
		s3client.putObject(new PutObjectRequest(bucketName, key, inputStream, meta));
		return key;
	}
	
	public InputStream getFile(String bucketName, String key) {
		S3Object o = s3client.getObject(new GetObjectRequest(bucketName, key));
		return o.getObjectContent();
	}
	
}
