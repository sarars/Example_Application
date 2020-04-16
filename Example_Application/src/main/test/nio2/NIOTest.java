package main.test.nio2;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.junit.jupiter.api.Test;

class NIOTest {
	
	private static String HOME = System.getProperty("user.home");

	@Test
	void givenExistingPath_whenConfirmsFileExists_thenCorrect() {
		
		Path path = Paths.get(HOME);
		assertTrue(Files.exists(path));
	}

	@Test
	void givenExistingPath_whenConfirmsFileNotExists_thenCorrect() {

		Path path = Paths.get(HOME + "/inexistentFile.txt");
		assertTrue(Files.notExists(path));
	}
	
	@Test
	void givenExistingPath_whenConfirmsDirectoryExists_thenCorrect() {

		String dirName = "NIO2";
		Path path = Paths.get(HOME + "/" + dirName);
		assertTrue(Files.exists(path));
	}
	
	@Test
	void givenExistingPath_whenConfirmsDirectoryNotExists_thenCorrect() {

		String dirName = "myDir_" + UUID.randomUUID().toString();
		Path path = Paths.get(HOME + "/" + dirName);
		assertTrue(Files.notExists(path));
	}
	
	@Test
	void givenExistingPath_whenConfirmsIsReadable_thenCorrect() {

		String dirName = "NIO2";
		Path path = Paths.get(HOME + "/" + dirName + "/isReadable.txt");
		assertTrue(Files.isReadable(path));
	}
	
	@Test
	void givenExistingPath_whenConfirmsIsWritable_thenCorrect() {

		String dirName = "NIO2";
		Path path = Paths.get(HOME + "/" + dirName + "/isWritable.txt");
		assertTrue(Files.isWritable(path));
	}
	
	@Test
	void givenExistingPath_whenConfirmsIsExecutable_thenCorrect() {

		String dirName = "NIO2";
		Path path = Paths.get(HOME + "/" + dirName + "/executable.exe");
		assertTrue(Files.isExecutable(path));
	}
	
	@Test
	void givenExistingPath_whenConfirmsIsSame_thenCorrect() throws IOException {

		Path path1 = Paths.get(HOME);
		Path path2 = Paths.get(HOME);
		assertTrue(Files.isSameFile(path1, path2));
	}
	
	@Test
	void givenExistingPath_whenConfirmsCreatedFile() throws IOException {

		String dirName = "NIO2";
		String fileName = "myFile_" + UUID.randomUUID().toString();
		Path path = Paths.get(HOME + "/" + dirName + "/" + fileName);
		Files.createFile(path);
		assertTrue(Files.exists(path));
	}
	
	@Test
	void givenExistingPath_whenConfirmsCreatedDirectory() throws IOException {

		String dirName = "NIO2";
		String newDirName = "myDir_" + UUID.randomUUID().toString();
		Path path = Paths.get(HOME + "/" + dirName + "/" + newDirName);
		Files.createDirectory(path);
		assertTrue(Files.exists(path));
	}
	
	@Test
	void givenExistingPath_whenFailsToCreateRecursively() throws IOException {

		String dirName = "NIO2-";
		String fileName = "myFile_" + UUID.randomUUID().toString();
		Path path = Paths.get(HOME + "/" + dirName + "/" + fileName);
		assertThrows(NoSuchFileException.class, () -> Files.createFile(path));
	}
	
	@Test
	void givenExistingPath_whenConfirmsCreatedDirectoryRecursively() throws IOException {

		String dirName = "NIO2";
		String newDirName = "myDir_" + UUID.randomUUID().toString();
		Path path = Paths.get(HOME + "/" + dirName + "/" + newDirName);
		Path subDir = path.resolve("subDir");
		
		Files.createDirectories(subDir);
		
		assertTrue(Files.exists(path));
		assertTrue(Files.exists(subDir));
	}
	
	@Test
	void givenExistingPath_whenConfirmsCreatedTemporaryFile() throws IOException {

		String prefix = "log_";
		String suffix = ".txt";
		String dirName = "NIO2";
		Path path = Paths.get(HOME + "/" + dirName + "/" );
		Files.createTempFile(path, prefix, suffix);
		assertTrue(Files.exists(path));
	}
	
	@Test
	void givenExistingPath_whenConfirmsCreatedTemporaryFileWithDefaults() throws IOException {

		String dirName = "NIO2";
		Path path = Paths.get(HOME + "/" + dirName + "/" );
		Files.createTempFile(path, null, null);
		assertTrue(Files.exists(path));
	}
	
	@Test
	void givenExistingPath_whenConfirmsCreatedTemporaryFileInTempDir() throws IOException {

		Path path = Files.createTempFile(null, null);
		assertTrue(Files.exists(path));
	}
	
	@Test
	void givenExistingPath_whenConfirmsDeletedFile() throws IOException {

		String dirName = "NIO2";
		String fileName = "myFile_" + UUID.randomUUID().toString();
		Path path = Paths.get(HOME + "/" + dirName + "/" + fileName );
		
		assertFalse(Files.exists(path));
		
		Files.createFile(path);
		
		assertTrue(Files.exists(path));
		
		Files.delete(path);
		
		assertTrue(Files.notExists(path));
	}
	
	@Test
	void givenExistingPath_whenFailsToDeleteFile() throws IOException {

		String dirName = "NIO2";
		String fileName = "myFile_" + UUID.randomUUID().toString();
		Path path = Paths.get(HOME + "/" + dirName + "/" + fileName );
		
		assertThrows(NoSuchFileException.class, () -> Files.delete(path) );
	}
	
	@Test
	void givenExistingPath_whenDeleteFileIfExist() throws IOException {

		String dirName = "NIO2";
		String fileName = "myFile_" + UUID.randomUUID().toString();
		Path path = Paths.get(HOME + "/" + dirName + "/" + fileName );
		
		Files.deleteIfExists(path);
	}
	
	@Test
	void givenExistingPath_whenDirectoryNotEmpty() throws IOException {

		String dirName = "NIO2";
		String subDirName = "myDir_" + UUID.randomUUID().toString();
		Path path = Paths.get(HOME + "/" + dirName + "/" + subDirName );
		Path subSubDir = path.resolve("subSubDir");
		Files.createDirectories(subSubDir);
		
		assertThrows(DirectoryNotEmptyException.class, () -> Files.delete(path));
	}
	
	@Test
	void givenExistingPath_whenCopyFile() throws IOException {
		
		String dirName = "NIO2";
		String dirName1 = "myDir1_" + UUID.randomUUID().toString();
		String dirName2 = "myDir2_" + UUID.randomUUID().toString();
		Path dir1 = Paths.get(HOME + "/" + dirName + "/" + dirName1 );
		Path dir2 = Paths.get(HOME + "/" + dirName + "/" + dirName2 );
		
		Files.createDirectory(dir1);
		Files.createDirectory(dir2);
		
		Path file1 = dir1.resolve("fileToCopy.txt");
		Path file2 = dir2.resolve("fileToCopy.txt");
		
		Files.createFile(file1);
		
		assertTrue(Files.exists(file1));
		assertTrue(Files.notExists(file2));
		
		Files.copy(file1, file2);
		
		assertTrue(Files.exists(file2));
		
		
	}
	
	@Test
	void givenExistingPath_whenCopyFailsIfFileExist() throws IOException {
		
		String dirName = "NIO2";
		String dirName1 = "myDir1_" + UUID.randomUUID().toString();
		String dirName2 = "myDir2_" + UUID.randomUUID().toString();
		Path dir1 = Paths.get(HOME + "/" + dirName + "/" + dirName1 );
		Path dir2 = Paths.get(HOME + "/" + dirName + "/" + dirName2 );
		
		Files.createDirectory(dir1);
		Files.createDirectory(dir2);
		
		Path file1 = dir1.resolve("fileToCopy.txt");
		Path file2 = dir2.resolve("fileToCopy.txt");
		
		Files.createFile(file1);
		Files.createFile(file2);
		
		assertTrue(Files.exists(file1));
		assertTrue(Files.exists(file2));
		
		Files.copy(file1, file2,StandardCopyOption.REPLACE_EXISTING);
		
	}
	
	@Test
	void givenExistingPath_whenMoveFile() throws IOException {
		
		String dirName = "NIO2";
		String dirName1 = "myDir1_" + UUID.randomUUID().toString();
		String dirName2 = "myDir2_" + UUID.randomUUID().toString();
		Path dir1 = Paths.get(HOME + "/" + dirName + "/" + dirName1 );
		Path dir2 = Paths.get(HOME + "/" + dirName + "/" + dirName2 );
		
		Files.createDirectory(dir1);
		Files.createDirectory(dir2);
		
		Path file1 = dir1.resolve("fileToCopy.txt");
		Path file2 = dir2.resolve("fileToCopy.txt");
		
		Files.createFile(file1);
		
		assertTrue(Files.exists(file1));
		assertTrue(Files.notExists(file2));
		
		Files.move(file1, file2);
		
		assertTrue(Files.exists(file2));
		assertTrue(Files.notExists(file1));
		
		
	}
	
	@Test
	void givenExistingPath_whenMoveFailsIfFileExist() throws IOException {
		
		String dirName = "NIO2";
		String dirName1 = "myDir1_" + UUID.randomUUID().toString();
		String dirName2 = "myDir2_" + UUID.randomUUID().toString();
		Path dir1 = Paths.get(HOME + "/" + dirName + "/" + dirName1 );
		Path dir2 = Paths.get(HOME + "/" + dirName + "/" + dirName2 );
		
		Files.createDirectory(dir1);
		Files.createDirectory(dir2);
		
		Path file1 = dir1.resolve("fileToCopy.txt");
		Path file2 = dir2.resolve("fileToCopy.txt");
		
		Files.createFile(file1);
		Files.createFile(file2);
		
		assertTrue(Files.exists(file1));
		assertTrue(Files.exists(file2));
		
		Files.move(file1, file2,StandardCopyOption.REPLACE_EXISTING);
		
	}

}
