1. Word - Đại diện cho một “từ” trong văn bản.

A/ Vai trò
Tách thành prefix (ký tự đặc biệt phía trước), text (phần chữ/số chính), suffix (ký tự đặc biệt phía sau). Có danh sách stopWords (các từ bỏ qua).

B/Hàm:
-createWord(rawText) → parse ra Word.
-isKeyword() → kiểm tra có phải keyword hợp lệ không.
-equals() → so sánh dựa vào text (case-insensitive).

2. Doc-Đại diện cho một document (một file .txt).
Tách thành 2 phần:
title (dòng đầu tiên) và body (các dòng còn lại).
* Hàm:
- Parse nội dung thành list Word (title + body).
- Cung cấp getTitle(), getBody().
- equals() để so sánh doc theo title + body.

3. Query - Đại diện cho câu search của người dùng
A/ Vai trò: Chỉ giữ lại keywords (sau khi bỏ stopwords).

B/ Hàm
- getKeywords() → trả về list keyword theo đúng thứ tự.
- matchAgainst(Doc d) → so sánh keywords với một Doc, trả về list Match (mỗi keyword có bao nhiêu lần xuất hiện trong doc).
- 
4. Match - Đại diện cho một keyword xuất hiện trong một doc.

Vai trò: Giữ thông tin (Doc, Word, frequency, firstIndex).

Hàm: compareTo() → để sắp xếp matches theo độ quan trọng (vị trí xuất hiện sớm, tần suất nhiều, chữ cái).

5. Result - Đại diện cho kết quả khi search một doc.
A/ Vai trò: Gom nhiều Match thuộc cùng một doc.

B/ Hàm
- getMatches() → lấy danh sách matches.
- getTotalFrequency() → tổng số lần keyword xuất hiện trong doc.
- getAverageFirstIndex() → trung bình vị trí lần đầu các keyword.
- htmlHighlight() → in doc với keyword được highlight.
- compareTo() → so sánh 2 Result để xếp hạng (doc nào liên quan hơn).

6. Engine -“Bộ máy” tìm kiếm.

Hàm:
- loadDocs(dirname) → load tất cả file trong thư mục thành Doc.
- getDocs() → trả về các doc đã load.

search(Query q) → chạy query trên toàn bộ docs → tạo list Result.

htmlResult(results) → in toàn bộ kết quả dưới dạng HTML.
