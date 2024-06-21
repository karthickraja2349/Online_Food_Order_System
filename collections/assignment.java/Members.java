class Member {
    int memberId;
    String memberName;
    HashMap<Integer, Member> memberList;

    public Member(int memberId, String memberName) {
        this.memberId = memberId;
        this.memberName = memberName;
    }

    public Member() {
        memberList = new HashMap<>();
    }

    public String toString() {
        return memberId + " " + memberName;
    }

    public int getId() {
        return memberId;
    }

    public void members() {
        Member member1 = new Member(1001, "gambhir");
        Member member2 = new Member(1002, "samson");
        Member member3 = new Member(1003, "cummins");
        Member member4 = new Member(1004, "starc");

        memberList.put(member1.memberId, member1);
        memberList.put(member2.memberId, member2);
        memberList.put(member3.memberId, member3);
        memberList.put(member4.memberId, member4);

        System.out.println(memberList);
    }

    public Member getMember(int id) {
        return memberList.get(id);
    }
}
