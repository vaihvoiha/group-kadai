<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>科目管理システム</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
		    border-bottom: 1px solid #DDDDDD; /* 薄いグレーの線 */
		    padding: 8px;
		    text-align: left;
		}
        h2 {
            background-color: #EEEEEE;
        }
        a.right-align {
            float: right;
        }
        .spaced-link {
            margin-right: 100px; /* 右側に10pxのスペースを追加 */
        }
    </style>
</head>
<body>
    <!-- 画面タイトル -->
    <h2>科目管理</h2>

    <!-- 新規登録リンク -->
    <a href="subject_create.jsp" class="right-align">新規登録</a>

    <!-- 科目一覧テーブル -->
    <table>
        <thead>
            <tr>
                <!-- ヘッダ（科目コード） -->
                <th>科目コード</th>
                <!-- ヘッダ（科目名） -->
                <th>科目名</th>
                <!-- 操作 -->
                <th></th>
            </tr>
        </thead>
        <tbody>
            <!-- 科目情報（科目コード） -->
            <tr>
                <td></td>
                <!-- 科目情報（科目名） -->
                <td></td>
                <!-- 科目情報変更リンク -->
                <td>
                    <a href="subject_update.jsp?id=001" class="spaced-link">変更</a>
                    <!-- 科目情報削除リンク -->
                    <a href="subject_delete.jsp?id=001">削除</a>
                </td>
            </tr>
            <!-- 追加の科目情報 -->
            <tr>
                <td></td>
                <td></td>
                <td>
                    <a href="subject_update.jsp?id=002" class="spaced-link">変更</a>
                    <a href="subject_delete.jsp?id=002">削除</a>
                </td>
            </tr>
        </tbody>
    </table>
</body>
</html>