class Member {
    int MemberId;
    String MemberName;

    public Member(int MemberId, String MemberName) {
        this.MemberId = MemberId;
        this.MemberName = MemberName;
    }

    public String toString() {
        return "Member id is" + MemberId + "MemberName is" + MemberName;
    }
}

