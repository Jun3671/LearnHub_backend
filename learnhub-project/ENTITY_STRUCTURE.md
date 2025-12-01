# 북마크 서비스 엔티티 구조

## 📋 엔티티 개요

| 엔티티 | 테이블명 | 역할 | 주요 관계 |
|--------|----------|------|-----------|
| **User** | users | 사용자 인증 및 소유권 관리 | User → Category (1:N)<br>User → Bookmark (1:N) |
| **Category** | categories | 북마크 분류 (예: Frontend, AWS) | Category → Bookmark (1:N)<br>Category ← User (N:1) |
| **Bookmark** | bookmarks | 저장된 링크 정보 | Bookmark ← User (N:1)<br>Bookmark ← Category (N:1)<br>Bookmark → BookmarkTag (1:N) |
| **Tag** | tags | 북마크 키워드 (예: Spring, JPA) | Tag → BookmarkTag (1:N) |
| **BookmarkTag** | bookmark_tags | **북마크-태그 연결 중간 테이블** | BookmarkTag ← Bookmark (N:1)<br>BookmarkTag ← Tag (N:1) |

## 🔗 관계 구조

```
User (1) ──────< (N) Category
  │
  └─────< (N) Bookmark >─────┐
                 │            │
                 │            │
          (N) ──┴── (1)       │
         BookmarkTag          │
          (N) ──┬── (1)       │
                 │            │
                Tag <─────────┘
```

## 📊 주요 필드

### User
- `id`: PK, Auto Increment
- `email`: UNIQUE, NOT NULL
- `password`: NOT NULL (암호화 저장)
- `role`: NOT NULL, 기본값 "USER"
- `createdAt`: 생성 시간

### Category
- `id`: PK, Auto Increment
- `name`: NOT NULL
- `user_id`: FK → User
- `createdAt`: 생성 시간

### Bookmark
- `id`: PK, Auto Increment
- `user_id`: FK → User
- `category_id`: FK → Category
- `url`: NOT NULL
- `title`: 북마크 제목
- `description`: 설명 (최대 1000자)
- `s3_thumbnail_url`: S3 썸네일 이미지 URL
- `createdAt`: 생성 시간

### Tag
- `id`: PK, Auto Increment
- `name`: UNIQUE, NOT NULL

### BookmarkTag (중간 테이블)
- `id`: PK, Auto Increment
- `bookmark_id`: FK → Bookmark
- `tag_id`: FK → Tag

## 🎯 핵심 설계 포인트

### 1. N:M 관계 해소
- **Bookmark ↔ Tag**의 다대다 관계를 **BookmarkTag** 중간 엔티티로 해소
- JPA `@ManyToMany` 대신 `@OneToMany` + `@ManyToOne` 조합 사용
- 추후 "태그 추가 시간" 등 추가 필드 확장 가능

### 2. Cascade 및 Orphan Removal
- `User` 삭제 시 → `Category`, `Bookmark` 자동 삭제
- `Bookmark` 삭제 시 → `BookmarkTag` 자동 삭제
- `Category` 삭제 시 → `Bookmark` 자동 삭제
- `Tag` 삭제 시 → `BookmarkTag` 자동 삭제

### 3. Lazy Loading
- 모든 연관관계는 `FetchType.LAZY` 사용하여 성능 최적화
- N+1 문제 발생 시 Fetch Join 또는 EntityGraph 적용 예정

### 4. 자동 생성 시간
- `createdAt` 필드는 `@PrePersist`로 자동 설정
- `updatable = false`로 수정 방지

## 🚀 다음 단계

1. **Repository 계층** 작성 (JpaRepository 상속)
2. **Service 계층** 비즈니스 로직 구현
3. **REST API** 개발
   - 북마크 CRUD (생성, 조회, 수정, 삭제)
   - 카테고리/태그 필터링
   - 썸네일 S3 업로드
4. **Spring Security + JWT** 인증 구현