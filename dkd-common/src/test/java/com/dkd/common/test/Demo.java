package com.dkd.common.test;

/**
 * @author Author
 * @date 2024-12-05 17:03
 */
import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;

import java.io.FileInputStream;
import java.io.InputStream;

public class Demo {
	public static void main(String[] args) throws com.aliyuncs.exceptions.ClientException {
		// 1. OSS服务的Endpoint，具体Region需根据实际情况填写。
		String endpoint = "https://oss-cn-hangzhou.aliyuncs.com";

		// 2. 从环境变量中获取访问凭证，请确保已设置环境变量：
		//    OSS_ACCESS_KEY_ID和OSS_ACCESS_KEY_SECRET。
		EnvironmentVariableCredentialsProvider credentialsProvider =
				CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();

		// 3. 配置Bucket名称
		String bucketName = "web-tlias-lrr";

		// 4. 配置Object完整路径（不包含Bucket名称）。
		String objectName = "xiaoxin.png";

		// 5. 本地文件路径（需要上传的文件）。
		String filePath = "E:\\javaweb\\delivery-resources\\ruoyi\\uploadPath\\upload\\2024\\12\\05\\xiaoxin.png";

		// 6. 创建OSSClient实例。
		OSS ossClient = new OSSClientBuilder().build(endpoint, credentialsProvider);

		try {
			// 7. 读取本地文件流。
			InputStream inputStream = new FileInputStream(filePath);

			// 8. 创建PutObjectRequest对象，设置Bucket名称、Object名称和文件输入流。
			PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, inputStream);

			// 9. 执行上传操作。
			PutObjectResult result = ossClient.putObject(putObjectRequest);

			// 打印上传结果信息（可选）。
			System.out.println("Upload succeeded. ETag: " + result.getETag());
		} catch (OSSException oe) {
			// 捕获OSS服务端错误。
			System.err.println("Caught an OSSException. Details:");
			System.err.println("Error Message: " + oe.getErrorMessage());
			System.err.println("Error Code: " + oe.getErrorCode());
			System.err.println("Request ID: " + oe.getRequestId());
			System.err.println("Host ID: " + oe.getHostId());
		} catch (ClientException ce) {
			// 捕获客户端错误。
			System.err.println("Caught a ClientException. Details:");
			System.err.println("Error Message: " + ce.getMessage());
		} catch (Exception e) {
			// 捕获其他可能的异常。
			System.err.println("Unexpected exception occurred: " + e.getMessage());
		} finally {
			// 10. 关闭OSSClient实例，释放资源。
			if (ossClient != null) {
				ossClient.shutdown();
			}
		}
	}
}
