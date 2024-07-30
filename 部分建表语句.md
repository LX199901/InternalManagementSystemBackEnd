-- 社員情報テーブルの作成
CREATE TABLE employees (
    employee_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '社員ID、一意に各社員を識別する',
    name VARCHAR(50) NOT NULL COMMENT '社員の名前',
    sex VARCHAR(2) NOT NULL COMMENT '性別（例：“男”または“女”）',
    phone VARCHAR(50) COMMENT '電話番号',
    email VARCHAR(100) UNIQUE COMMENT 'メールアドレス、一意',
    birthday DATE COMMENT '生年月日',
    position_id INT NOT NULL COMMENT '職位ID、職位テーブルと関連付ける',
    department_id INT NOT NULL COMMENT '部門ID、部門テーブルと関連付ける',
    hire_date DATE NOT NULL COMMENT '入社日',
    leave_date DATE COMMENT '退社日、退社していない場合はNULL',
    is_active VARCHAR(10) DEFAULT '在職中' COMMENT '社員の状態（例：“在職中”または“退職”）',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'レコード作成日',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'レコード最終更新日',
    del_flag INT DEFAULT 0 COMMENT '削除フラグ、0は削除されていない、1は削除された',
    contact_id INT COMMENT '上司ID、社員テーブル内の別レコードと関連付ける',
    company_id VARCHAR(50) COMMENT '会社ID、会社テーブルと関連付ける'
) COMMENT = '社員の基本情報を保存するテーブル';

-- 給与テーブルの作成
CREATE TABLE salary (
    salary_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '給与ID、一意に各給与レコードを識別する',
    employee_id INT NOT NULL COMMENT '社員ID、社員テーブルと関連付ける',
    attendance_days INT NOT NULL DEFAULT 0 COMMENT '出勤日数',
    working_hours TIME NOT NULL DEFAULT '00:00:00' COMMENT '勤務時間',
    basic_salary DECIMAL(10, 2) NOT NULL COMMENT '基本給',
    overtime_allowance DECIMAL(10, 2) NOT NULL DEFAULT 0 COMMENT '残業手当',
    residential_allowance DECIMAL(10, 2) NOT NULL DEFAULT 0 COMMENT '住宅手当',
    transportation_allowance DECIMAL(10, 2) NOT NULL DEFAULT 0 COMMENT '交通手当',
    other_allowance DECIMAL(10, 2) NOT NULL DEFAULT 0 COMMENT 'その他手当',
    payment DECIMAL(10, 2) NOT NULL COMMENT '総支給額',
    health_insurance_premium DECIMAL(10, 2) NOT NULL DEFAULT 0 COMMENT '健康保険料',
    pension_insurance_premium DECIMAL(10, 2) NOT NULL DEFAULT 0 COMMENT '厚生年金保険料',
    employment_insurance_premium DECIMAL(10, 2) NOT NULL DEFAULT 0 COMMENT '雇用保険料',
    withholding_tax DECIMAL(10, 2) NOT NULL DEFAULT 0 COMMENT '源泉所得税',
    deduction DECIMAL(10, 2) NOT NULL COMMENT '総控除額',
    other_pay DECIMAL(10, 2) COMMENT 'その他の支払い',
    total_salary DECIMAL(10, 2) NOT NULL COMMENT '総給与額',
    payment_date DATE NOT NULL COMMENT '給与生成日',
    payment_issue_date DATE NOT NULL COMMENT '給与支給日'
) COMMENT = '社員の給与情報を保存するテーブル';

-- 給与設定テーブルの作成
CREATE TABLE salary_settings (
    salary_set_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '給与設定ID、一意に各設定レコードを識別する',
    employee_id INT NOT NULL COMMENT '社員ID、社員テーブルと関連付ける',
    basic_salary DECIMAL(10, 2) NOT NULL DEFAULT 230000 COMMENT '基本給',
    transportation_allowance_max DECIMAL(10, 2) NOT NULL DEFAULT 20000 COMMENT '交通手当の上限',
    residential_allowance_max DECIMAL(10, 2) NOT NULL DEFAULT 30000 COMMENT '住宅手当の上限',
    other_allowance_max DECIMAL(10, 2) NOT NULL DEFAULT 10000 COMMENT 'その他手当の上限',
    update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'レコード最終更新日'
) COMMENT = '社員の給与設定情報を保存するテーブル';

-- 出勤記録テーブルの作成
CREATE TABLE attendance_records (
    record_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '記録ID、一意に各出勤記録を識別する',
    employee_id INT NOT NULL COMMENT '社員ID、社員テーブルと関連付ける',
    att_date DATE NOT NULL COMMENT '出勤日',
    clock_in_time TIME COMMENT '出勤時刻',
    break_start TIME COMMENT '休憩開始時刻',
    break_end TIME COMMENT '休憩終了時刻',
    clock_out_time TIME COMMENT '退勤時刻',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'レコード作成日',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'レコード最終更新日',
    break_time VARCHAR(10) COMMENT '休憩時間の合計',
    working_hours VARCHAR(10) COMMENT '実働時間',
    explanation VARCHAR(100) COMMENT '出勤説明',
    UNIQUE (employee_id, att_date) COMMENT '社員ごとに1日のレコードが一意であることを保証する'
) COMMENT = '社員の出勤記録を保存するテーブル';

-- 経費申請テーブルの作成
CREATE TABLE expense_application (
    expense_application_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '経費申請ID、一意に各申請レコードを識別する',
    employee_id INT NOT NULL COMMENT '社員ID、社員テーブルと関連付ける',
    application_date DATE NOT NULL COMMENT '申請日',
    total_amount DECIMAL(10, 2) NOT NULL COMMENT '総金額',
    processing_status_id VARCHAR(50) NOT NULL COMMENT '処理状態ID、申請の処理状態を示す',
    approver_id INT COMMENT '承認者ID、社員テーブルと関連付ける',
    deletion_flag VARCHAR(1) NOT NULL DEFAULT '0' COMMENT '削除フラグ、0は削除されていない、1は削除された',
    deletion_date DATE COMMENT '削除日',
    settlement_amount DECIMAL(10, 2) NOT NULL DEFAULT 0 COMMENT '精算金額',
    comment VARCHAR(50) COMMENT '申請に関するコメント',
    update_day DATE NOT NULL COMMENT 'レコード最終更新日'
) COMMENT = '経費申請情報を保存するテーブル';

-- 経費明細テーブルの作成
CREATE TABLE expense_details (
    expense_details_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '経費明細ID、一意に各明細レコードを識別する',
    cost_id VARCHAR(50) NOT NULL COMMENT '費用名ID、費用テーブルと関連付ける',
    amount DECIMAL(10, 2) NOT NULL COMMENT '申請金額',
    hasTax CHAR(1) NOT NULL COMMENT '税金の有無、Yは税金あり、Nは税金なし',
    proof_path VARCHAR(250) NOT NULL COMMENT '証明書類のパス',
    expense_application_id INT NOT NULL COMMENT '経費申請ID、経費申請テーブルと関連付ける',
    comment VARCHAR(50) COMMENT '明細に関するコメント',
    update_day DATE NOT NULL COMMENT 'レコード最終更新日'
) COMMENT = '経費明細';

-- 費用テーブルの作成
CREATE TABLE cost (
    expense_id INT NOT NULL PRIMARY KEY COMMENT '費用ID、一意に各費用タイプを識別する',
    expense_name VARCHAR(50) NOT NULL COMMENT '費用名',
    remark VARCHAR(255) COMMENT '備考',
    update_day DATE COMMENT 'レコード最終更新日',
    UNIQUE (expense_name) COMMENT '費用名が一意であることを保証する'
) COMMENT = '費用タイプの情報を保存するテーブル';



INSERT INTO cost (expense_id, expense_name, remark, update_day) VALUES
(1, 'タクシー代', NULL, NULL),
(2, '飲食代', NULL, NULL),
(3, '旅行費', NULL, NULL),
(4, '定期券', NULL, NULL);


CREATE TABLE `common` (
  `generic_key` varchar(50) NOT NULL COMMENT '汎用KEY、汎用データの種類を示す',
  `generic_id` varchar(50) NOT NULL COMMENT '汎用ID、一意に各データを識別する',
  `generic_name` varchar(100) NOT NULL COMMENT '汎用名称、汎用データの名称',
  `description` varchar(255) DEFAULT NULL COMMENT '説明、汎用データの説明',
  PRIMARY KEY (`generic_key`, `generic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='汎用データを保存するテーブル';


INSERT INTO `common` (`generic_key`, `generic_id`, `generic_name`, `description`)
VALUES 
('PROCESSING_STATUS', 'S1', '承認まち', '処理状態'),
('PROCESSING_STATUS', 'S2', '承認済み', '処理状態'),
('PROCESSING_STATUS', 'S3', '承認不可', '処理状態'),
('PROCESSING_STATUS', 'S4', '精算中', '処理状態'),
('PROCESSING_STATUS', 'S5', '清算済み', '処理状態');


-- 追加する社員データ
INSERT INTO `employees` (`name`, `sex`, `phone`, `email`, `birthday`, `position_id`, `department_id`, `hire_date`, `leave_date`, `is_active`, `contact_id`, `company_id`)
VALUES
('山田太郎', '男', '090-1234-5678', 'taro.yamada@example.com', '1980-01-15', 1, 1, '2010-04-01', NULL, '在職中', NULL, 'ABC株式会社'),
('佐藤花子', '女', '080-9876-5432', 'hanako.sato@example.com', '1985-07-22', 2, 2, '2012-09-01', NULL, '在職中', 1, 'XYZ株式会社'),
('鈴木一郎', '男', '070-3456-7890', 'ichiro.suzuki@example.com', '1978-11-30', 3, 1, '2008-03-15', '2023-05-31', '退職', NULL, 'DEF株式会社'),
('田中美咲', '女', '090-6543-2109', 'misaki.tanaka@example.com', '1990-12-05', 4, 3, '2015-06-01', NULL, '在職中', 2, 'GHI株式会社');


-- 給与設定データを追加
INSERT INTO `salary_settings` (`employee_id`, `basic_salary`, `transportation_allowance_max`, `residential_allowance_max`, `other_allowance_max`)
VALUES
(1, '250000.00', '22000.00', '32000.00', '12000.00'), -- 山田太郎
(2, '270000.00', '21000.00', '31000.00', '11000.00'), -- 佐藤花子
(3, '230000.00', '20000.00', '30000.00', '10000.00'), -- 鈴木一郎
(4, '240000.00', '21000.00', '31000.00', '11000.00'); -- 田中美咲


-- 経費申請データを追加
INSERT INTO `expense_application` (`employee_id`, `application_date`, `total_amount`, `processing_status_id`, `approver_id`, `deletion_flag`, `deletion_date`, `settlement_amount`, `comment`, `update_day`)
VALUES
(1, '2024-07-30', '15000.00', '処理中', NULL, '0', NULL, '0.00', '定期代申請', '2024-07-30'),  -- 山田太郎
(2, '2024-07-30', '20000.00', '処理中', NULL, '0', NULL, '0.00', '飲食代申請', '2024-07-30'),  -- 佐藤花子
(3, '2024-07-30', '18000.00', '処理中', NULL, '0', NULL, '0.00', '定期代申請', '2024-07-30'),  -- 鈴木一郎
(4, '2024-07-30', '22000.00', '処理中', NULL, '0', NULL, '0.00', '飲食代申請', '2024-07-30');  -- 田中美咲


-- 経費明細データを追加
INSERT INTO `expense_details` (`cost_id`, `amount`, `hasTax`, `proof_path`, `expense_application_id`, `comment`, `update_day`)
VALUES
(4, '15000.00', 'Y', '/path/to/ticket1.jpg', 1, '定期代', '2024-07-30'),  -- 山田太郎
(2, '20000.00', 'N', '/path/to/receipt1.jpg', 2, '昼食会の費用', '2024-07-30'),  -- 佐藤花子
(4, '18000.00', 'Y', '/path/to/ticket2.jpg', 3, '定期代', '2024-07-30'),  -- 鈴木一郎
(2, '22000.00', 'N', '/path/to/receipt2.jpg', 4, '夕食会の費用', '2024-07-30');  -- 田中美咲


-- 生成2024年6月的工资记录

INSERT INTO `salary` (
  `employee_id`, 
  `attendance_days`, 
  `working_hours`, 
  `basic_salary`, 
  `overtime_allowance`, 
  `residential_allowance`, 
  `transportation_allowance`, 
  `other_allowance`, 
  `payment`, 
  `health_insurance_premium`, 
  `pension_insurance_premium`, 
  `employment_insurance_premium`, 
  `withholding_tax`, 
  `deduction`, 
  `other_pay`, 
  `total_salary`, 
  `payment_date`, 
  `payment_issue_date`
)
VALUES 
-- 山田太郎
(1, 22, '08:00:00', 230000.00, 5000.00, 30000.00, 20000.00, 10000.00, 275000.00, 5000.00, 10000.00, 2000.00, 3000.00, 15000.00, 0.00,262000.00, '2024-06-30', '2024-07-05'),

-- 佐藤花子
(2, 20, '07:30:00', 230000.00, 6000.00, 25000.00, 18000.00, 9000.00, 275000.00, 5500.00, 11000.00, 2200.00, 3300.00, 10000.00, 0.00,261500.00, '2024-06-30', '2024-07-05'),

-- 鈴木一郎
(3, 21, '08:15:00', 230000.00, 5500.00, 28000.00, 21000.00, 9500.00, 275000.00, 5200.00, 10400.00, 2080.00, 3120.00, 5000.00,0.00, 258580.00, '2024-06-30', '2024-07-05'),

-- 田中美咲
(4, 23, '08:00:00', 230000.00, 4500.00, 29000.00, 22000.00, 9500.00, 275000.00, 4800.00, 9600.00, 1920.00, 2880.00, 2000.00,0.00, 260700.00, '2024-06-30', '2024-07-05');
