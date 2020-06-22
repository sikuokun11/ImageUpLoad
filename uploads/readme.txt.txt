Hướng dẫn chạy chương trình: 
	- Copy Thư mục DATA trong Source vào ổ đĩa D:
	- Sau đó mở cmd và gõ dòng lệnh sau vào và ENTER: 
		chcp 65001 & cmd
		java -jar -Dfile.encoding=UTF8  C:\Users\fxqta\Desktop\1712147\Dictionary.jar (Lưu ý đường dẫn này phải thay đổi khi đặt file jar)
		(do cmd không có chuẩn UTF8 nên cần thêm như dòng trên để hiển thị chuỗi tiếng việt có dấu trong chương trình ) 
	- Do cmd không nhập tiếng việt vào được nên chỉ xử lý với từ tiếng việt không dấu,
	- Có thể test trên Intellij với source code có sẵn để tra cứu và thao tác đối với từ tiếng việt có dấu (Xem video demo)
	- mở project Dictionary trong thư mục Source bằng Intellij
	- Khi thêm hoặc xóa 1 từ, bạn phải thoát chương trình hoặc ấn chọn ngôn ngữ của từ điển để cập nhật từ trong từ điển đó
	- Nếu lỗi chương trình có thể test lại bằng cách xóa thư mục DATA và copy lại thư mục DATA ban đầu vào ổ đĩa D lại
	- Đối với nhập ngày yêu cầu nhập đúng định dạng dd/MM/yyyy
	
Link Video Hướng dẫn : https://www.youtube.com/watch?v=7fXqGAGv218